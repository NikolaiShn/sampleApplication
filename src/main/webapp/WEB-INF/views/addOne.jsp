<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
    <div>
		<form method="POST" enctype="multipart/form-data"  action="/addOneRecord">
			<table>
				<tr><td>number</td><td><input type="number" min = "0" step = "0.01", name="number" /></td></tr>
				<tr><td>text</td><td><input type="text" name="text" /></td></tr>
				<tr><td>time</td><td><input type="datetime-local" name="time" /></td></tr>
				<tr><td>image</td><td><input type="file" name="file" /></td></tr>
				<tr><td></td><td><input type="submit" value="Upload" /></td></tr>
			</table>
		</form>
	</div>
</html>