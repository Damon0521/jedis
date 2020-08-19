package com.enjoylearning.mybatis.config;

/**
 * @program: mybatismyself_simple
 * @description:
 * @author: damon
 * @create: 2020-08-15 18:48
 **/

/*首先对于这个内容这个情况 */
public class MappedStatement {

    private String namespace;
    private String sourceId;
    private String resultType;
    private  String sql;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
