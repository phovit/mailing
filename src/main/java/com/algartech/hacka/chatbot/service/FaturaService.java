package com.algartech.hacka.chatbot.service;

import com.algartech.hacka.chatbot.jobs.MailingJob;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.repository.MailingRepository;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pauloho on 15/09/18.
 */
@Service
public class FaturaService {




}
