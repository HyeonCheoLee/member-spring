package hello.hellospring.vo;

/**
 * packageName    : hello.hellospring.vo
 * fileName       : memberVo
 * author         : hyunc
 * date           : 2022-11-13
 * description    : memberVo
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-13        hyunc       최초 생성
 */
public class MemberVo {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
