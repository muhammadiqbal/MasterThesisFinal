package com.iqbal.masterthesis.cargomailparser;

/**
 * FMeasure
 */
public class FMeasure {

    private float accuracy = 0f; 
    private float[] precision = null; 
    private float[] recall = null; 
    private float avgPrecision = 0f; 
    private float avgRecall = 0f; 

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(float[] precision) {
        this.precision = precision;
    }

    /**
     * @param recall the recall to set
     */
    public void setRecall(float[] recall) {
        this.recall = recall;
    }

    /**
     * @param avgRecall the avgRecall to set
     */
    public void setAvgRecall(float avgRecall) {
        this.avgRecall = avgRecall;
    }

    /**
     * @param avgPrecision the avgPrecision to set
     */
    public void setAvgPrecision(float avgPrecision) {
        this.avgPrecision = avgPrecision;
    }


    /**
     * @return the accuracy
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * @return the recall
     */
    public float[] getRecall() {
        return recall;
    }

    /**
     * @return the avgPrecision
     */
    public float getAvgPrecision() {
        return avgPrecision;
    }

    /**
     * @return the avgRecall
     */
    public float getAvgRecall() {
        return avgRecall;
    }
}