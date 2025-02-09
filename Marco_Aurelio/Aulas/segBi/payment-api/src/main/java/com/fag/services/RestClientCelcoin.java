package com.fag.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.fag.dto.ConsultaBoletoDTO;
import com.fag.dto.TokenDTO;

import io.vertx.codegen.doc.Token;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://sandbox.openfinance.celcoin.dev")
public interface RestClientCelcoin {

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    TokenDTO getToken(Form form);

    @POST
    @Path("/v5/transactions/billpayments/authorize")
    String consult(@HeaderParam("Authorization") String token, ConsultaBoletoDTO dto);

    @POST
    @Path("/v5/transactions/billpayments")
    String payment(@HeaderParam("Authorization") String token, ConsultaBoletoDTO dto);
}