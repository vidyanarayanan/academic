package com.vn.util;

import com.vn.ds.HierarchicalList;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by i841928 on 12/8/16.
 */
public class HierarchicalListPopulator<E> {
    private HierarchicalList<E> hl;

    public HierarchicalListPopulator() {
    }

    public static void main(String[] args) throws Exception {

        String contents = new String(Files.readAllBytes(Paths.get("hldata.txt")));
        System.out.println("Contents (Java 7) : " + contents);


    }


}
