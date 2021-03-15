package com.auch.camel.ftp.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author luohuiqi
 * @Description:
 * @Date: 2021/1/21 15:31
 */
public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String originalFileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String changedFileName = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + originalFileName;
        exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
    }
}
