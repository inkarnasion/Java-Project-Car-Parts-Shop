package org.softuni.carpartsshop.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softuni.carpartsshop.config.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@RequestMapping("/")
	public String index() {
		logger.trace(Constant.TRACE_MESSEGE);
		logger.debug(Constant.DEBUG_MESSEGE);
		logger.info(Constant.INFO_MESSEGE);
		logger.warn(Constant.WARN_MESSEGE);
		logger.error(Constant.AN_ERROR_MESSEGE);

		return Constant.RETURN_LOG_MESSEGE;
	}
}