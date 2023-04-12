package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;

public record UserFilter(
        String name,
        String email,
        Integer page,
        Integer size
) {
    @Override
    public Integer page() {
        return NumberUtils.isNull(page) ? 0 : (page - 1);
    }
}
