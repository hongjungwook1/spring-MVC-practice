package com.example.demo.member.controller;

import com.example.demo.member.controller.dto.MemberCreateRequestDto;
import com.example.demo.member.controller.dto.MemberResponseDto;
import com.example.demo.member.service.MemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
@RequestMapping("/member")
public class MemberController {

    MemberService memberService;

    @PostMapping("")
    public ResponseEntity<MemberResponseDto> create(@RequestBody MemberCreateRequestDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponseDto> read(@PathVariable Integer id) {
        return ResponseEntity.ok(memberService.read(id));
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<MemberResponseDto>> readAll() {
        return ResponseEntity.ok(memberService.readAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberResponseDto> update(@RequestBody MemberCreateRequestDto dto, @PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.update(dto, id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        memberService.delete(id);
    }
}
