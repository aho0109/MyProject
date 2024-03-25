//package com.joyfulgarden.util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.joyfulgarden.model.Posts;
//import com.joyfulgarden.model.PostsRepository;
//import com.joyfulgarden.model.Replies;
//
//import java.util.List;
//
//@Service
//public class RecommendationService {
//
//    @Autowired
//    private PostsRepository postsRepository;
//
////    public List<Posts> getRecommendedPosts(String queryStr, int numResults) throws Exception {
////        List<Posts> posts = postsRepository.findAll(); // Assuming you have a method to retrieve all posts
////        TFIDFService tfidfService = new TFIDFService();
////        tfidfService.indexPosts(posts);
////        return tfidfService.searchPosts(queryStr, numResults);
////    }
//    
//    public List<Posts> generateRecommendations(Posts currentPost, List<Replies> replies) {
//        try {
//            // 在這裡根據給定的帖子和回覆生成推薦的文章
//            // 你可以使用 TF-IDF 或者其他推薦算法來實現這一功能
//            // 這裡只是一個示例，實際實現中需要根據你的業務邏輯進行調整
//            // 假設我們使用 TF-IDFService 來計算推薦文章
//            TFIDFService tfidfService = new TFIDFService();
//            tfidfService.indexPosts(postsRepository.findAll()); // 假設 findAll() 方法可以獲取所有帖子
//            return tfidfService.searchPosts(currentPost.getPostContent(), 5); // 假設要獲取10篇推薦文章
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 返回空列表或者錯誤訊息，視情況而定
//            return null;
//        }
//    }
//}
