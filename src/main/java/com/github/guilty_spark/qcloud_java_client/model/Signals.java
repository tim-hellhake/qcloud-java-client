package com.github.guilty_spark.qcloud_java_client.model;

/**
 * A list of signals
 *
 * @author guilty-spark
 */
public class Signals {
    private final Integer size = null;
    private final String sort = null;
    private final Boolean hasNextPage = null;
    private final Integer totalElements = null;
    private final Integer totalPages = null;
    private final Signal[] content = null;

    /**
     * @return the number of Signals displayed by page
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @return the sorting of the signals
     */
    public String getSort() {
        return sort;
    }

    /**
     * @return true if there are still Signals to be retrieved on next pages
     */
    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    /**
     * @return the total number of Signals
     */
    public Integer getTotalElements() {
        return totalElements;
    }

    /**
     * @return the total number of pages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @return the list of signals
     */
    public Signal[] getContent() {
        return content;
    }
}
