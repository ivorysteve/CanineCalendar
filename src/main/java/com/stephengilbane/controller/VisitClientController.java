package com.stephengilbane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephengilbane.dto.VisitClientDTO;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.service.VisitClientBusinessService;

import io.swagger.annotations.Api;

@Api(
        value = "Client",
        tags = { "VisitClient" }
)
@RestController
@RequestMapping("/caninescheduler/clients")
public class VisitClientController
{
    private final VisitClientBusinessService clientService;
    
    /**
     * Constructor
     * @param svc VisitClientBusinessService
     */
    @Autowired
    VisitClientController(VisitClientBusinessService svc) 
    {
        this.clientService = svc;
    }

    
    /**
     * Get all VisitClient objects.
     * @return List, possibly empty, of VisitClientDTOs
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<VisitClientDTO> getAllClients() 
    {
        return clientService.getAllVisitClients();
    }
    
    /**
     * Get a VisitClient object.
     * @param clientId Primary Key
     * @return VisitClientDTO
     * @throws ItemNotFoundException if client does not exist.
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public VisitClientDTO readClient(@PathVariable Long clientId) 
    {
        VisitClientDTO vc = clientService.getVisitClient(clientId);
        if (vc == null)
        {
            throw new ItemNotFoundException("VisitClient", clientId);
        }
        
        return vc;
    }
    
    /**
     * Create a new dog visit client.
     * @param input
     * @return ResponseEntity containing body.
     * 
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody VisitClientDTO vc) 
    {

        clientService.validateVisitClient(vc);
        
        VisitClientDTO vcResult = clientService.createVisitClient(vc);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vcResult.getId()).toUri());
        return new ResponseEntity<>(vcResult, httpHeaders, HttpStatus.CREATED);
    }

}
