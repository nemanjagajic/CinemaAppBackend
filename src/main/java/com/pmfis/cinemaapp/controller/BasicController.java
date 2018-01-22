package com.pmfis.cinemaapp.controller;

import java.util.List;

public interface BasicController<Request, Response> {
    List<Response> getAll();
    Response getById(int id);
    Response post(Request entity);
    Response put(int id, Request entity);
    Response delete(int id);
}
