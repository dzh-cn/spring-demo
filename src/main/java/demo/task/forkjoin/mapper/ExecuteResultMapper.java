package demo.task.forkjoin.mapper;

import demo.task.forkjoin.entity.ExecuteResult;

/**
 * 执行结果输出
 */
public interface ExecuteResultMapper {
    int insert(ExecuteResult record);

    int insertSelective(ExecuteResult record);

    ExecuteResult selectByPrimaryKey(Long resultId);

    int updateByPrimaryKeySelective(ExecuteResult record);

    int updateByPrimaryKey(ExecuteResult record);
}