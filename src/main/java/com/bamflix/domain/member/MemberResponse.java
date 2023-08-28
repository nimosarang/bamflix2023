package com.bamflix.domain.member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class MemberResponse {              // 회원 데이터 조회에 사용될 응답 클래스

    private Long id;                       // 회원 번호 (PK)
    private String loginId;                // 로그인 ID
    private String password;               // 비밀번호
    private String name;                   // 이름
    private String email;                  // 이메일
    private String phone;                  // 휴대폰번호
    private Gender gender;                 // 성별
    private LocalDate birthday;            // 생년월일
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시

    public void clearPassword() {
        this.password = "";                // 회원 상세정보 조회 후, 비번 초기화 용도
    }

}
