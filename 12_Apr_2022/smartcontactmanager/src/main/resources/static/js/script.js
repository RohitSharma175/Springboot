console.log("Tesing");

const toggleSidebar = ()=>{
    if($(".sidebar").is(":visible"))
    {
        $(".sidebar").css("display","none");
        $(".content").css("margin-left","0%");
        // close side bar
    }
    else{
        // oprn sidebar 
        $(".sidebar").css("display","block");
        $(".content").css("margin-left","20%");
    }

}