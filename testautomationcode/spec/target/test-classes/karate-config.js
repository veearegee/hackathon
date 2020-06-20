 function() {   
  var config = {
    apiURL: 'http://35.188.114.237:8088'
  };
  
  karate.configure('connectTimeout', 50000);
  karate.configure('readTimeout', 5000);
  return config;
}