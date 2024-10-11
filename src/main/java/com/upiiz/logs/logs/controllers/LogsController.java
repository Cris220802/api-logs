package com.upiiz.logs.logs.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.logs.logs.models.LogsModel;
import com.upiiz.logs.logs.services.LogsService;

@RestController
@RequestMapping("/api/v1/logs")
public class LogsController {

    // Inyeccion de dependencias de logsService
    LogsService logsService;

    public LogsController (LogsService logsService) {
        this.logsService = logsService;
    }

    // GET - Todas las categorias
    @GetMapping
    public ResponseEntity<List<LogsModel>> getLogs(){
        return ResponseEntity.ok(logsService.getAllLogs());
    }

    // GET - solo una categoria
    @GetMapping("/{id}")
    public ResponseEntity<LogsModel> getLogById(@PathVariable Long id){
        return ResponseEntity.ok(logsService.getLogById(id));
    }

    // POST - Crear una categoria
    @PostMapping
    public ResponseEntity<LogsModel> addLog(@RequestBody LogsModel log){
        return ResponseEntity.ok(logsService.createLog(log));
    }
    // PUT . Actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<LogsModel> updateLog(@RequestBody LogsModel log, @PathVariable Long id){
        log.setLogId(id);
        return ResponseEntity.ok(logsService.updateLog(log));
    }

    // DELETE - Eliminar una categoria por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id){
        logsService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
