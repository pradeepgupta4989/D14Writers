# Digital 14 Coding Task

Problem Statement : There are two kinds of Writers: StringWriter which writes to a String and FileWriter that writes to a file (these are not related to those classes provided in Java). There can be other types of Writers (like SocketWriter that writes to a Socket) in the future.

 #### How to execute :
# Rest endpoint 1: Perform Operations on input text and then write it to WRITER.
- Input Text, Operations to be performed on Text, Writers : where text needs to be written
- POST http://localhost:9080/api/v1/write-text
- Sample Json Input :
```
{
    "text": "This is really really stupid!! ",
    "writers": [
        "file_writer",
        "string_writer"
    ],
    "operations": [
        "lower_case",
        "stupid_remover",
        "duplicate_remover"
    ]
}
- Output result :
this is really s*****!!
```
# Rest endpoint 2: Read Text from the WRITERS
- GET http://localhost:9080/api/v1/content/file_writer - To read file_writer data
- GET http://localhost:9080/api/v1/content/string_writer - To read String_writer data
- Output result :
this is really s*****!!

# Rest endpoint 3 : Close Writer after this text won't be written by Writer
-POST http://localhost:9080/api/v1/close-write
- Sample Json Input :
```
{
    "writers" :["file_writer", "string_writer"]
}
- Output result :
Writer Closed successfully
```


