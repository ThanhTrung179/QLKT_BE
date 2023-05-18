package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;
import lombok.Getter;
import lombok.Setter;


public record UserFilter(
        String name,
        String idUser,
        Integer page,
        Integer size
) {
    @Override
    public Integer page() {
        return NumberUtils.isNull(page) ? 0 : (page - 1);
    }
}
