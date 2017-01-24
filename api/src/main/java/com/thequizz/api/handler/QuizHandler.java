package com.thequizz.api.handler;

import com.thequizz.api.model.Coordinate;
import com.thequizz.api.model.Location;
import com.thequizz.api.model.Quiz;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class QuizHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getRequest().getBody()
                .then(body -> {
                    System.out.println("##### BODY: "+body);
                    ctx.getResponse().contentType("application/json").status(200);
                    ctx.render(json(new Quiz("id", new Location("Tower Hill", new Coordinate(100d, 100d)))));
                });

    }
}
