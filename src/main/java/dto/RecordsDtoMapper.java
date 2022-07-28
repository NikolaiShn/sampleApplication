package dto;

import model.Record;
import org.mapstruct.Mapper;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordsDtoMapper {

    List<RecordDto> recordsToRecordDtos(List<Record> records);
    RecordDto recordToRecordDto(Record record);

    default String toString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
