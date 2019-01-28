package com.iqbal.masterthesis.cargomailparser.helper;

import java.util.List;

import com.iqbal.masterthesis.cargomailparser.languagemodel.Commision;
import com.iqbal.masterthesis.cargomailparser.languagemodel.Description;
import com.iqbal.masterthesis.cargomailparser.languagemodel.LDRate;
import com.iqbal.masterthesis.cargomailparser.languagemodel.LaycanDate;
import com.iqbal.masterthesis.cargomailparser.languagemodel.PortDestination;
import com.iqbal.masterthesis.cargomailparser.languagemodel.Quantity;
import com.iqbal.masterthesis.cargomailparser.languagemodel.StowageFactor;
import com.iqbal.masterthesis.cargomailparser.model.BaseModel;
import com.iqbal.masterthesis.cargomailparser.model.Cargo;


/**
 * EntityMapper
 */
public class EntityMapper {
    public static List<Cargo> mapEntities(List<BaseModel> models) {
        List<Description> descriptions; 
        List<Commision> commisions;
        List<LaycanDate> laycanDates;
        List<LDRate> ldRates;
        List<PortDestination> portDestinations;
        List<Quantity> quantities;
        List<StowageFactor> stowageFactors;
        List<Cargo> cargo = null;
        // for (BaseModel model : models) {
        //     switch (model.getModelType()) {
        //         case "Quantity":
        //             .add(model);
        //         case "Laycan Date":
        //             .add(model);
        //         case "Port Destination":
        //             .add(model);
        //         case "Commision":
        //             .add(model);
        //         case "Description":
        //             .add(model);
        //         case "Ld rate":
        //             .add(model);
        //         case "stowage factor":
        //             .add(model);
        //         default:
        //             break;
                
        //     }
        // }
        return cargo;
    }
    
}