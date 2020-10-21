package com.cafe.controller;

import com.cafe.entity.ATable;
import com.cafe.entity.Category;
import com.cafe.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/table")
public class TableController {
    public TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<ATable> ListTable() {
        return tableService.TableList();
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public ATable detailsTable(@PathVariable int id) {
        return tableService.GetTable(id);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createTable(@Valid @RequestBody ATable table) {
        tableService.SaveTable(table);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTable(@Valid @RequestBody ATable table) {
        tableService.SaveTable(table);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTable(@PathVariable Integer id) {
        tableService.DeleteTable(id);
        return ResponseEntity.ok("success!");
    }
}
