package com.mailer.cass.service;

import com.mailer.cass.exception.EntityNotFoundException;
import com.mailer.cass.model.Mail;
import com.mailer.cass.repo.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {
    private final MailRepository mailRepository;

    @Autowired
    private MailService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public Mail storeMessage(Mail mail) {
        return mailRepository.save(mail);
    }

    public List<Mail> sendMessages(Integer magicNumber) {

        if (magicNumber == null) {
            throw new IllegalArgumentException();
        }

        List<Mail> mails = mailRepository.findAllByMagicNumber(magicNumber);

        if (mails.isEmpty()) {
            throw new EntityNotFoundException(magicNumber);
        }

        mailRepository.deleteAll(mails);

        return mails;
    }

    public List<Mail> mailsByEmail(String email, Integer page) {
        int PAGE_SIZE = 5;
        List<Mail> mails = mailRepository.findAllByEmail(email, PageRequest.of(page, PAGE_SIZE));

        if (mails.isEmpty()) {
            throw new EntityNotFoundException(email);
        }

        return mails;
    }
}
