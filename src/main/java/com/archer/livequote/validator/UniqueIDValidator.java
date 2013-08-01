package com.archer.livequote.validator;

import java.io.Serializable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.archer.livequote.dao.CrudDao;

public class UniqueIDValidator implements
		ConstraintValidator<Unique, Serializable> {

	private Class<?> entityClass;
	private String uniqueField;
	  @Autowired
	    public CrudDao crud;

	public void initialize(Unique unique) {
		this.entityClass=unique.entity();
		this.uniqueField=unique.property();
	}

	public boolean isValid(Serializable property,
			ConstraintValidatorContext cvContext) {
		
		return crud.getByField(uniqueField, (String)property, entityClass)==null;
	}

}