package com.example.zombiesApi.utils;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class Report {
    double infected ;
    double size ;

    public Report(int infectedNumber, int size) {
        this.infected = infectedNumber;
        this.size = size;
    }

    public String getReport(){
         final DecimalFormat df = new DecimalFormat("0.00");
        if(infected >0){
            double x = 0.0;
            x= (( this.infected/this.size )* 100);
            return "infected percentage is " +df.format(x)+"%"  ;
        }else {
            return " no infection " ;
        }

    }
}
