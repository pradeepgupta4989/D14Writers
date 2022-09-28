package com.d14.writers.controller;

import com.d14.writers.Service.OperationService;
import com.d14.writers.model.CloseWriterReq;
import com.d14.writers.model.WriteTextReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class RestApiController {

	private final OperationService operationService;

	@PostMapping("/write-text")
	public String writeText(@RequestBody WriteTextReq writeTextReq) {
		log.info("List of operations : {}", writeTextReq);
		if(!StringUtils.isEmpty(writeTextReq.getText()) &&
				!CollectionUtils.isEmpty(writeTextReq.getOperations())) {
			return operationService.processTextAndWrite(writeTextReq);
		}
		return "Please provide input text or list of operations";
	}

	@PostMapping("/close-write")
	public String closeWrite(@RequestBody CloseWriterReq closeWriterReq) {
		log.info("Close writing for writers : {}", closeWriterReq.getWriters());
		if(!CollectionUtils.isEmpty(closeWriterReq.getWriters())) {
			 operationService.closeWrite(closeWriterReq.getWriters());
			 return "Writer Closed successfully";
		}
		return "Please provide writer name in request";
	}

	@GetMapping("/content/{writer}")
	public String readContent(@PathVariable String writer) {
		return operationService.readFile(writer);
	}
}