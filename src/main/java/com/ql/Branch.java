package com.ql;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.MapUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Branch extends BaseStatement {

    private Map<JudgeStatement, List<Statement>> judgeStatementMapping;

    public Branch() {
        setStatementType(StatementType.BRANCH);
        judgeStatementMapping = new LinkedHashMap<>();
    }

    public void cond(JudgeStatement judgeStatement, Statement... statements) {
        judgeStatementMapping.put(judgeStatement, Lists.newArrayList(statements));
    }

    @Override
    public String express() {
        if (MapUtils.isEmpty(judgeStatementMapping)) {
            return "";
        } else {
            return appendBranch();
        }
    }

    private String appendBranch() {
        StringBuilder content = new StringBuilder();
        int i = 1;
        for (Map.Entry<JudgeStatement, List<Statement>> mapping : judgeStatementMapping.entrySet()) {
            JudgeStatement judge = mapping.getKey();
            List<Statement> statements = mapping.getValue();
            if (i == 1) {
                content.append("if(").append(judge.express()).append("){").append(appendStatements(statements)).append("}");
            } else {
                content.append("else if(").append(judge.express()).append("){").append(appendStatements(statements)).append("}");
            }
            i++;
        }
        return content.toString();
    }

    private String appendStatements(List<Statement> statements) {
        StringBuilder sb = new StringBuilder();
        statements.forEach(statement -> sb.append(statement.express()));
        return sb.toString();
    }

}
