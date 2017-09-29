# gs-rest-service-cors
springboot springsecurity basic cors
1.基于springboot

2.集成springsecurity

3.权限校验basic方式,解决跨域同源问题

4.跨域放开
public class WebConfig extends WebMvcConfigurerAdapter {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}

5.frameOptions().disable()禁用同源限制,antMatchers(HttpMethod.OPTIONS).permitAll()放开跨域时的预请求(OPTION请求),
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable().and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().cors().disable()
                .httpBasic().and();
    }
    
6.springsecurity默认用户名密码,admin:admin
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }
    
7.前端请求
  var url = 'http://xxxxx/greeting';
        var username = "admin";
        var password = "admin";
        $.ajax
        ({
            type: "GET",
            url: url,
            async: false,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function () {
                alert('Thanks for your comment!');
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
                console.log("before send")
            }
        });
