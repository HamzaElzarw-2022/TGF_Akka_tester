package org.sk.i2i.evren.TGF;

import akka.actor.AbstractActor;
import org.sk.i2i.evren.DataTransaction;
import org.sk.i2i.evren.SmsTransaction;
import org.sk.i2i.evren.VoiceTransaction;

public class AkkaActor extends AbstractActor {

    int dataTransactionsCounter = 0;
    int voiceTransactionsCounter = 0;
    int smsTransactionsCounter = 0;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match( DataTransaction.class, this::onDataTransaction )
                .match( VoiceTransaction.class, this::onVoiceTransaction )
                .match( SmsTransaction.class, this::onSmsTransaction )
                .matchAny(o -> System.out.println("received unknown message"))
                .build();
    }

    public void onDataTransaction(DataTransaction dataTransaction) {

        dataTransactionsCounter++;

        if(dataTransactionsCounter % 10 == 0) {
            printStats();
        }

    }

    public void onVoiceTransaction(VoiceTransaction voiceTransaction) {

        voiceTransactionsCounter++;

        if(voiceTransactionsCounter % 10 == 0) {
            printStats();
        }

    }

    public void onSmsTransaction(SmsTransaction smsTransaction) {

        smsTransactionsCounter++;

        if(smsTransactionsCounter % 10 == 0) {
            printStats();
        }

    }

    public void printStats() {

        System.out.print(
                "DATA: " + dataTransactionsCounter +
                "  ,VOICE: " + voiceTransactionsCounter +
                "  ,SMS: " + smsTransactionsCounter +
                "  ,TOTAL: " + (dataTransactionsCounter + voiceTransactionsCounter + smsTransactionsCounter) +
                "\r");
    }
}
