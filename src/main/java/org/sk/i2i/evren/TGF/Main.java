package org.sk.i2i.evren.TGF;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class Main {
    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("TGFSystemCopy", ConfigFactory.load("application.conf"));
        system.actorOf(Props.create(AkkaActor.class), "TGFActorCopy");

    }
}