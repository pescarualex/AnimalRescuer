package org.fasttrackit.controler;

import org.fasttrackit.controler.utils.ScannerUtils;

public class StdInControler {

    public String getNameOfDog() {
        return ScannerUtils.readNetSingleLine();
    }

    public String getNameOfCat() {
        return ScannerUtils.readNetSingleLine();
    }


}
