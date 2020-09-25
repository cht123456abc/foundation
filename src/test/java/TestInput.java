import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInput {

    public static void main(String[] args) {
        String content = "SELECT pr_rule.*,sys_task_rule.`rule_type`,sys_task_rule.`interval_time`,sys_task_rule.`cron_exp` FROM (\n" +
                "SELECT pre_pr.*,parse_rule.`rule_name`,parse_rule.`dependency_depth`,parse_rule.`default_rule` FROM (\n" +
                "SELECT sub_1.*,COUNT(CASE WHEN vul_level=\"4\" THEN vul_level END) level4,COUNT(CASE WHEN vul_level=\"3\" THEN vul_level END) level3,COUNT(CASE WHEN vul_level=\"2\" THEN vul_level END) level2,COUNT(CASE WHEN vul_level=\"1\" THEN vul_level END) level1,COUNT(CASE WHEN vul_level=\"0\" THEN vul_level END) level0 FROM (\n" +
                "SELECT sub.*,count(repo_items.repo_name) AS lib_number,count(DISTINCT repo_items.license) AS license_types FROM (\n" +
                "SELECT UUID() AS id,prod.NAME AS product_name,prod.id AS product_id,ptask.*FROM (\n" +
                "SELECT id,NAME FROM product WHERE user_id=189) prod LEFT JOIN (\n" +
                "SELECT t.*,p.`product_id` AS pd_id,p.NAME,p.`create_time`,p.`last_scan`,p.`url`,p.`project_source`,p.`rule_id` FROM project p,(\n" +
                "SELECT id AS tid,project_id,msg,STATUS,`progress` FROM sys_task WHERE id IN (\n" +
                "SELECT MAX(id) AS id FROM sys_task GROUP BY project_id)) t WHERE t.project_id=p.id) ptask ON prod.id=ptask.pd_id) sub LEFT JOIN repo_items ON sub.project_id=repo_items.project_id GROUP BY sub.project_id) sub_1 LEFT JOIN defects USING (project_id) GROUP BY sub_1.project_id) pre_pr LEFT JOIN parse_rule ON pre_pr.rule_id=parse_rule.id) pr_rule LEFT JOIN sys_task_rule ON pr_rule.project_id=sys_task_rule.project_id WHERE (\n" +
                "SELECT IF (LENGTH(TRIM(\"\"))> 0,pr_rule.NAME LIKE '%' \"\" '%',1=1)) ORDER BY create_time DESC";

        System.out.println(content.replaceAll("\n",""));
    }
}
