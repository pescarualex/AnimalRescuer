package org.fasttrackit.controler;

import org.fasttrackit.controler.utils.ScannerUtils;

public class StdInControler {

    public String getNameOfDog() {
        return ScannerUtils.readNextSingleLine();
    }

    public String getNameOfCat() {
        return ScannerUtils.readNextSingleLine();
    }


}
