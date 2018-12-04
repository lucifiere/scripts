package com.scripts

def code = """
public interface ActivityBudgetService {

    boolean subtractBudget(Long activityId, BudgetType budgetType, int count);

    boolean addBudget(Long activityId, BudgetType budgetType, int count);

    boolean releaseBudget(List<Long> activityIds, String orderId,List<ActivityBudgetFlowDO> activityBudgetFlowDOs);

    boolean confirmBudget(List<Long> activityIds, String orderId,List<ActivityBudgetFlowDO> activityBudgetFlowDOs);

    /**
     * 同步redis 周期性预算
     */
    void syncActivityBudget();

    /**
     * 根据活动id 同步redis 周期性预算
     */
    void syncBudget(Long activityId);
}
"""

def methods = []

def serviceName = ""

code.split("\n").each {
    if (!it.isEmpty()) {
        String[] token = it.split(" ")
        if (token.contains("interface")) {
            serviceName = token[2]
        } else if (token.contains("(")) {
            def method = [:]
            method["return"] = token[0]
            method["name"] = token[1]
            char[] cs = token[1].toCharArray()
            cs[0] = ((cs[0] as int) + 32) as char
            def cfName = String.valueOf(cs)
            method["cfName"] = cfName
            String[] firstParam = token[2].split("\\(")
            if(firstParam){

            }

        }
    }
}


char[] cs = serviceName.toCharArray()
cs[0] = ((cs[0] as int) + 32) as char
def cfServiceName = String.valueOf(cs)

def body = """"""
methods.each {
    def ele = it as Map
    def params = ""
    def i = 1
    ele["params"].each {
        params += """${it} var${i}, """
        i++
    }
    body += """
    @Test
    public void test${ele["cfName"]}(){
        ${ele["return"]} result = ${serviceName}.${ele["name"]}(${params});
        System.out.println(JSON.toJSONString(result));
        Assert.notNull(result);
    }    
"""
}

def res = """
public class ${cfServiceName}Test extends BaseTest {

    @Autowired
    ${cfServiceName} ${serviceName};

    ${body} 

}


"""