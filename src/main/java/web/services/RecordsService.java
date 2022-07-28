package web.services;

import dto.RecordDto;
import dto.RecordsDtoMapper;
import exceptions.BigLengthException;
import exceptions.BlankException;
import exceptions.IncorrectDataInput;
import exceptions.IncorrectFileFormat;
import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import web.dao.RecordsRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RecordsService {

    @Autowired
    private RecordsRepository recordsRepository;
    @Autowired
    private RecordsDtoMapper recordsDtoMapper;

    @Transactional
    public List<RecordDto> loadRecords() {
        List<Record> allRecords = recordsRepository.findAll();
        return recordsDtoMapper.recordsToRecordDtos(allRecords);
    }

    @Transactional
    public void saveRecords(Double number, String text, String time, MultipartFile image) throws BigLengthException, IncorrectFileFormat, IOException, BlankException, IncorrectDataInput {
        LocalDateTime timeData = LocalDateTime.parse(time.toString(),
                DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm")
        );
        if(image.getBytes().length > 16777215) {
            throw new BigLengthException("Большой размер картинки");
        }
        if(timeData.isBefore(LocalDateTime.now())) {
            throw new IncorrectDataInput("Старая дата");
        }
        if(text.length() > 255) {
            throw new BigLengthException("Слишком много символов текста");
        }
        if(number == null) {
            throw new BlankException("Поле number пустое");
        }
        if(text.isEmpty()) {
            throw new BlankException("Поле text пустое");
        }
        String fileName = image.getOriginalFilename();
        String originalFileName = fileName.split("\\.")[0];
        String fileExtension = fileName.split("\\.")[1];
        if( (!fileName.toLowerCase().endsWith(".jpg")) &&
            (!fileName.toLowerCase().endsWith(".jpeg")) &&
            (!fileName.toLowerCase().endsWith(".bmp")) &&
            (!fileName.toLowerCase().endsWith(".png")) &&
            (!fileName.toLowerCase().endsWith(".gif"))) {
            throw new IncorrectFileFormat("Некорректный формат файла");
        }
        if(originalFileName.length() > 255) {
            throw new BigLengthException("Слишком большое название файла");
        }
        Record record = new Record();
        byte [] imageInBytes = image.getBytes();
        record.setImage(imageInBytes);
        record.setNumber(number);
        record.setText(text);
        record.setDate(timeData);
        record.setImageOriginalName(originalFileName);
        record.setImageFormat(fileExtension);
        recordsRepository.save(record);
    }
}
