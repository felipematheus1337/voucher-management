package com.vouchers.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusinessUtils {

    public static final String LOTE_TOPIC_VOUCHER = "lote-voucher";
    private static final int DEFAULT_THREADS = 4;


    public static ExecutorService getExecutorByCPU() {
        int processors = Runtime.getRuntime().availableProcessors() | 4;
        ExecutorService executorService = Executors.newFixedThreadPool(processors);
        return executorService;
    }
}
