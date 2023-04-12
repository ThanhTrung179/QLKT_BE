package datn.qlkt.ultis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;


public class DataPage<T> implements Serializable {
    private int pageIndex;
    private int pageSize;
    private long pageCount;
    private long dataCount;
    private List<T> data;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static DataPage buildDataPage(List data, PageRequest paging, long dataCount) {
        DataPage dataPage = new DataPage();
        dataPage.setData(data);
        dataPage.setPageIndex(paging.getPageNumber());
        dataPage.setPageSize(paging.getPageSize());
        dataPage.setDataCount(dataCount);
        dataPage.setPageCount(dataPage.getDataCount() / dataPage.getPageSize());
        if (dataPage.getDataCount() % dataPage.getPageSize() != 0) {
            dataPage.setPageCount(dataPage.getPageCount() + 1);
        }
        return dataPage;
    }
}
