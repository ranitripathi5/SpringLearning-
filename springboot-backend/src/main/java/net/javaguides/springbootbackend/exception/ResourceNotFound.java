package net.javaguides.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException  {
    private static final long serialVersionUID=1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ResourceNotFound(String resourceName, String fieldName, Object fieldValue ) {
        super(String.format("%s not found with %s :'%s'", resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;//ieldName;
        this.fieldValue=fieldValue;
    }

}
