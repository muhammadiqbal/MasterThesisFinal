package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * Description
 */
public class Description extends BaseModel {

    private String description;

    public Description(String description) {
        this.description = description;
        this.modelType = "description";
	}

	/**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}