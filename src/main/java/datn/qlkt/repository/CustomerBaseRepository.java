package datn.qlkt.repository;

import datn.qlkt.ultis.DataPage;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface CustomerBaseRepository {
    DataPage<Object[]> queryHasParam(String query, Map<String, Object> params, PageRequest paging);

    List<Object[]> queryHasParam(String query, Map<String, Object> params);

    DataPage<Object[]> queryHasParam2(String query, Map<String, Object> params);

    Long getCount(String query, Map<String, Object> params);
}
