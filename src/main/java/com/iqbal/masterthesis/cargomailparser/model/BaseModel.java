package com.iqbal.masterthesis.cargomailparser.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * BaseModel
 */
public class BaseModel {
	public String modelType;
    public void toJson() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Convert object to JSON string
		    String jsonInString = mapper.writeValueAsString(this);
		    System.out.println(jsonInString);
        } catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * @return the modelType
	 */
	public String getModelType() {
		return modelType;
	}
}