package com.asiainfo.gim.monitor.api.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.monitor.domain.AlertConfig;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlertConfigValidator.Valicator.class)
public @interface AlertConfigValidator
{
	String message() default "AlertConfig bean validate fail!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class Valicator implements ConstraintValidator<AlertConfigValidator, AlertConfig>
	{
		@Context
		private ContainerRequestContext context;

		@Override
		public void initialize(AlertConfigValidator av)
		{

		}

		@Override
		public boolean isValid(AlertConfig alertConfig, ConstraintValidatorContext cvc)
		{
			if (StringUtils.equals(context.getMethod(), "POST"))
			{
				return validAlertConfig(alertConfig);
			}
			else if (StringUtils.equals(context.getMethod(), "PUT"))
			{
				if (alertConfig.getId() == null)
				{
					return false;
				}
				return validAlertConfig(alertConfig);
			}
			return true;
		}

		private boolean validAlertConfig(AlertConfig alertConfig)
		{
			if(alertConfig == null)
			{
				return false;
			}
			if (alertConfig.getProperties() == null || alertConfig.getType() == null)
			{
				return false;
			}
			return true;
		}

	}
}
