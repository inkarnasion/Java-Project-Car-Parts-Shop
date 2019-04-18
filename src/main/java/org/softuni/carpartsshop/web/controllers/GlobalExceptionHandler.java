package org.softuni.carpartsshop.web.controllers;

import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.error.NotFoundExceptions;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

	@ExceptionHandler({ NotFoundExceptions.class })
	public ModelAndView handleProductNotFound(RuntimeException e) {
		System.out.println(e);

		ModelAndView modelAndView = new ModelAndView(Constant.ERROR_NOT_FOUND);
		modelAndView.addObject(Constant.ADD_OBJECT_MESSAGE, e.getMessage());

		return modelAndView;
	}

	@ExceptionHandler({ Throwable.class })
	public ModelAndView handleSqlException(Throwable e) {
		ModelAndView modelAndView = new ModelAndView(Constant.ERROR_NOT_FOUND);
		Throwable throwable = e;
		System.out.println(e);

		while (throwable.getCause() != null) {
			throwable = throwable.getCause();
		}

		modelAndView.addObject(Constant.ADD_OBJECT_MESSAGE, throwable.getMessage());

		return modelAndView;
	}

	@ExceptionHandler({ IllegalArgumentException.class, })
	public ModelAndView handleIllegalArgumentExceptions(RuntimeException e) {
		System.out.println(e);

		ModelAndView modelAndView = new ModelAndView(Constant.ERROR_NOT_FOUND);
		modelAndView.addObject(Constant.ADD_OBJECT_MESSAGE, e.getMessage());

		return modelAndView;
	}
}
