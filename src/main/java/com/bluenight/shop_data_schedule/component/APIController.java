package com.bluenight.shop_data_schedule.component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bluenight.shop_data_schedule.component.data.MemberHashDataVO;
import com.bluenight.shop_data_schedule.component.data.MemberInfoVO;
import com.bluenight.shop_data_schedule.component.data.MemberProdVO;
import com.bluenight.shop_data_schedule.component.data.PageConnVO;
import com.bluenight.shop_data_schedule.component.data.ProductHashDataVO;
import com.bluenight.shop_data_schedule.component.data.ProductInfoVO;
import com.bluenight.shop_data_schedule.component.data.RecommandProdToMemberVO;
import com.bluenight.shop_data_schedule.component.data.ReviewInfoVO;
import com.bluenight.shop_data_schedule.component.data.ShoppingRecordVO;
import com.bluenight.shop_data_schedule.component.mapper.HistoryMapper;
import com.bluenight.shop_data_schedule.component.mapper.RecommendMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    @Value("${history.path}")
    String path;
    @Value("${history.conn.path}")
    String conn_path;
    @Value("${history.member_prod.path}")
    String member_prod_path;
    @Value("${history.review.path}")
    String review_path;
    @Value("${history.shopping_cart.path}")
    String shopping_cart_path;
    @Value("${history.shopping_cancel.path}")
    String shopping_cancel_path;
    @Value("${history.shopping_buy.path}")
    String shopping_buy_path;
    @Value("${history.member_info.path}")
    String member_info_path;
    @Value("${history.product_info.path}")
    String product_info_path;
    @Value("${recommend.hash.path}")
    String recommand_hash_path;
    @Value("${recommend.output.path}")
    String recommend_output_path;


    // memory allocation (메모리 할당), object instantiate (사용할 수 있는 객체로 만든다.)
    @Autowired HistoryMapper history_mapper;
    @Autowired RecommendMapper recommend_mapper;
    @GetMapping("/conn")
    public String userConnData(@RequestParam String start, @RequestParam String end) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();
        
        List<PageConnVO> list = history_mapper.selectPageConnHistory(startDt, endDt);
        Calendar c = Calendar.getInstance();
        String src = path+"connect"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(PageConnVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = conn_path+"connect"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);

        srcFile.renameTo(destFile);
        return "접속 기록 수집 스케줄 실행";
    }
    
    @GetMapping("/prod")
    public String userMemberProdData(@RequestParam String start, @RequestParam String end) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();

        List<MemberProdVO> list = history_mapper.selectMemberProdHistory(startDt, endDt);
        Calendar c = Calendar.getInstance();
        String src = path+"member_prod"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(MemberProdVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = member_prod_path+"member_prod"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);

        srcFile.renameTo(destFile);
        return "제품 조회 수집 스케줄 실행";
    }
    
    @GetMapping("/review")
    public String ReviewData(@RequestParam String start, @RequestParam String end) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();

        List<ReviewInfoVO> list = history_mapper.selectReviewInfo(startDt, endDt);
        Calendar c = Calendar.getInstance();
        String src = path+"member_prod"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(ReviewInfoVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = review_path+"review"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);

        srcFile.renameTo(destFile);
        return "리뷰 정보 수집 스케줄 실행";
    }
    
    @GetMapping("/shopping")
    public String shoppingData(@RequestParam String start, @RequestParam String end) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();

        List<ShoppingRecordVO> list = history_mapper.selectShoppingRecored(startDt, endDt, 0);
        Calendar c = Calendar.getInstance();
        String src = path+"shopping_cart"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(ShoppingRecordVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = shopping_cart_path+"shopping_cart"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);

        srcFile.renameTo(destFile);

        list = history_mapper.selectShoppingRecored(startDt, endDt, 1);
        // Calendar c = Calendar.getInstance();
        src = path+"shopping_buy"+c.getTimeInMillis()+".txt";
        writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(ShoppingRecordVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        dest = shopping_buy_path+"shopping_buy"+c.getTimeInMillis()+".txt";

        srcFile = new File(src);
        destFile = new File(dest);

        srcFile.renameTo(destFile);

        list = history_mapper.selectShoppingRecored(startDt, endDt, 2);
        // Calendar c = Calendar.getInstance();
        src = path+"shopping_cancel"+c.getTimeInMillis()+".txt";
        writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(ShoppingRecordVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        dest = shopping_cancel_path+"shopping_cancel"+c.getTimeInMillis()+".txt";

        srcFile = new File(src);
        destFile = new File(dest);

        srcFile.renameTo(destFile);
        return "쇼핑 정보 수집 스케줄 실행";
    }
    
    @GetMapping("/member")
    public String getMemberInfo(@RequestParam String start, @RequestParam String end) throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();

        List<MemberInfoVO> list = history_mapper.selectMemberInfo(startDt, endDt);
        Calendar c = Calendar.getInstance();
        String src = path+"member"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(MemberInfoVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = member_info_path+"member"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);
        srcFile.renameTo(destFile);

        return "회원정보 수집 스케줄 실행";
    }

    @GetMapping("/product")
    public String getProductInfo(@RequestParam String start, @RequestParam String end) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(
            Integer.parseInt(start.split("-")[0]),
            Integer.parseInt(start.split("-")[1])-1,
            Integer.parseInt(start.split("-")[2]),
            0,0,0
        );
        Date startDt = cal.getTime();
        cal.set(
            Integer.parseInt(end.split("-")[0]),
            Integer.parseInt(end.split("-")[1])-1,
            Integer.parseInt(end.split("-")[2]),
            23,59,59
        );
        Date endDt = cal.getTime();
        history_mapper.selectProductInfo(startDt, endDt);

        List<ProductInfoVO> list = history_mapper.selectProductInfo(startDt, endDt);
        Calendar c = Calendar.getInstance();
        String src = path+"product"+c.getTimeInMillis()+".txt";
        BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                new File(src)
            )
        );
        for(ProductInfoVO data : list) {
            writer.write(data.toString());
            writer.newLine();
        }
        writer.close();

        String dest = product_info_path+"product"+c.getTimeInMillis()+".txt";

        File srcFile = new File(src);
        File destFile = new File(dest);
        srcFile.renameTo(destFile);

    
        return "제품 정보 수집 스케줄 실행";
    }

    @GetMapping("/recommend")
    public String getRecommendData() throws Exception {
        File member_hash_file = new File(recommand_hash_path+"member/000000_0");
        File product_hash_file = new File(recommand_hash_path+"product/000000_0");
        File recommend_hash_file = new File(recommend_output_path+"part-r-00000");

        BufferedReader reader = new BufferedReader(new FileReader(member_hash_file));
        String line = null;

        List<MemberHashDataVO> member_list = new ArrayList<MemberHashDataVO>();
        List<ProductHashDataVO> product_list = new ArrayList<ProductHashDataVO>();
        List<RecommandProdToMemberVO> recommend_list = new ArrayList<RecommandProdToMemberVO>();

        while((line = reader.readLine()) != null){
            // System.out.println(line);
            MemberHashDataVO data = new MemberHashDataVO();
            // System.out.println(line.split("\\|")[0]);
            // System.out.println(line.split("\\|")[1]);
            // System.out.println(line.split("\\|")[2]);
            // if(line.split("|")[1].equals("\\")) continue;

            data.setMhd_hash(line.split("\\|")[0]);
            data.setMhd_email(line.split("\\|")[1]);
            try{
                data.setMhd_mi_seq(Integer.parseInt(line.split("\\|")[2]));
            }
            catch(NumberFormatException e) {
                //parseInt에서 발생, 숫자로 변환 불가할 때
                continue;
            }
            catch(ArrayIndexOutOfBoundsException e) {
                // null이 포함된 줄의 split 결과 배열의 길이는 2이기 때문에
                // 배열 인덱스 초과 예외가 발생
                continue;
            }
            // System.out.println(data);
            member_list.add(data);

        }
        reader.close();

        reader = new BufferedReader(new FileReader(product_hash_file));
        line = null;
        while((line = reader.readLine()) != null) {
            ProductHashDataVO data = new ProductHashDataVO();
            data.setPhd_hash(line.split("\\|")[0]);
            data.setPhd_name(line.split("\\|")[1]);
            try{
                data.setPhd_pi_seq(Integer.parseInt(line.split("\\|")[2]));
            }
            catch(NumberFormatException e) {
                continue;
            }
            catch(ArrayIndexOutOfBoundsException e) {
                continue;
            }
            // System.out.println(data);
            product_list.add(data);
        }
        reader.close();

        reader = new BufferedReader(new FileReader(recommend_hash_file));
        line = null;
        while((line = reader.readLine()) != null){
            // System.out.println(line);
            String member_hash = line.split("\\[")[0].trim();
            String[] product = line.split("\\[")[1].replaceAll("\\]", "").split(",");
            // System.out.println(member_hash);
            // System.out.println(product);
            for(int i=0; i<product.length; i++) {
                // System.out.println(product[i].split(":")[0]);
                // System.out.println(product[i].split(":")[1]);

                RecommandProdToMemberVO data = new RecommandProdToMemberVO();
                data.setRptm_memeber_hash(member_hash);
                data.setRptm_product_hash(product[i].split(":")[0]);
                data.setRptm_score(Double.parseDouble(product[i].split(":")[1]));
                // System.out.println(data);
                recommend_list.add(data);
            }

        }
        reader.close();

        recommend_mapper.insertMemberHashData(member_list);
        recommend_mapper.insertProductHashData(product_list);
        recommend_mapper.insetRecommandHashData(recommend_list);

        return "추천 정보를 가져왔습니다.";
    }


}