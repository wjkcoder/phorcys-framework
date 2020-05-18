package cn.phorcys.framework.database;

import cn.phorcys.framework.commons.utility.object.ObjectUtil;
import cn.phorcys.framework.commons.utility.object.StringUtil;
import cn.phorcys.framework.database.autofill.CommonFields;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CodeGenerator
 */
@Getter
@Setter
public class CodeGenerator {

    private DbType dbType;
    private String driverName;
    private String dbUrl;
    private String dbUserName;
    private String dbPassword;
    private String packageName;

    public CodeGenerator(DbType dbType, String driverName, String dbUrl, String dbUserName, String dbPassword, String packageName) {
        this.dbType = dbType;
        this.driverName = driverName;
        this.dbUrl = dbUrl;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
        this.packageName = packageName;
    }

    public void generate(String... tableName) {
        if (ObjectUtil.isNullOrEmpty(tableName)) {
            return;
        }

        Objects.requireNonNull(dbType, "dbType must not be null");
        StringUtil.requireNonNullOrEmptyOrWhitespace(driverName, "driverName must not be null or empty or whitespace");
        StringUtil.requireNonNullOrEmptyOrWhitespace(dbUrl, "dbUrl must not be null or empty or whitespace");
        StringUtil.requireNonNullOrEmptyOrWhitespace(dbUserName, "dbUserName must not be null or empty or whitespace");
        StringUtil.requireNonNullOrEmptyOrWhitespace(dbPassword, "dbPassword must not be null or empty or whitespace");

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("generator-output");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);//不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);//XML二级缓存
        gc.setBaseResultMap(true);//XML ResultMap
        gc.setBaseColumnList(false);//XML columList
        gc.setAuthor("Wonder");//作者

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(dbType);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        dsc.setDriverName(driverName);
        dsc.setUsername(dbUserName);
        dsc.setPassword(dbPassword);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{});//此处可以修改您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);//表名生成策略
        strategy.setInclude(tableName);//需要生成的表
        strategy.setLogicDeleteFieldName("DELETE_FLAG");

        // 表的自动填充字段
        List<TableFill> tableFills = new ArrayList<>();
        TableFill createdBy = new TableFill(CommonFields.CREATED_BY, FieldFill.INSERT);
        TableFill creationDate = new TableFill(CommonFields.CREATION_DATE, FieldFill.INSERT);
        TableFill lastUpdateDate = new TableFill(CommonFields.LAST_UPDATE_DATE, FieldFill.INSERT_UPDATE);
        TableFill lastUpdatedBy = new TableFill(CommonFields.LAST_UPDATED_BY, FieldFill.INSERT_UPDATE);
        TableFill lastUpdateLogin = new TableFill(CommonFields.LAST_UPDATE_LOGIN, FieldFill.INSERT_UPDATE);


        tableFills.add(createdBy);
        tableFills.add(creationDate);
        tableFills.add(lastUpdateDate);
        tableFills.add(lastUpdatedBy);
        tableFills.add(lastUpdateLogin);
        strategy.setTableFillList(tableFills);

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        //执行生成
        mpg.execute();

    }
}
