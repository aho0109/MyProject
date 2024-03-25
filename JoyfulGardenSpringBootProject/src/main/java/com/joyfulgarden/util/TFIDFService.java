//package com.joyfulgarden.util;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.queryparser.classic.QueryParser;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.ScoreDoc;
//import org.apache.lucene.search.TopDocs;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.RAMDirectory;
//import org.springframework.stereotype.Service;
//
//import com.joyfulgarden.model.Posts;
//
//@Service
//public class TFIDFService {
//
//    private Directory index;
//    private StandardAnalyzer analyzer;
//
//    public TFIDFService() {
//        this.index = new RAMDirectory();
//        this.analyzer = new StandardAnalyzer();
//    }
//
//    public void indexPosts(List<Posts> posts) throws IOException {
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter writer = new IndexWriter(index, config);
//        for (Posts post : posts) {
//            String postContent = post.getPostContent();
//            if (isFormatValid(postContent)) { // 检查格式是否符合要求
//                Document doc = new Document();
//                doc.add(new TextField("content", postContent, Field.Store.YES));
//                writer.addDocument(doc);
//            }
//        }
//        writer.close();
//    }
//
//    public List<Posts> searchPosts(String queryStr, int numResults) throws Exception {
//        IndexReader reader = DirectoryReader.open(index);
//        IndexSearcher searcher = new IndexSearcher(reader);
//        QueryParser parser = new QueryParser("content", analyzer);
//        Query query = parser.parse(queryStr);
//        TopDocs docs = searcher.search(query, numResults);
//        List<Posts> results = new ArrayList<>();
//        for (ScoreDoc scoreDoc : docs.scoreDocs) {
//            Document doc = searcher.doc(scoreDoc.doc);
//            String postContent = doc.get("content");
//            if (isFormatValid(postContent)) { // 检查格式是否符合要求
//                Posts post = getPostFromDocument(doc);
//                results.add(post);
//            }
//        }
//        reader.close();
//        return results;
//    }
//
//    private Posts getPostFromDocument(Document doc) {
//        // 這裡假設 Document 中只包含帖子的內容
//        Posts post = new Posts();
//        post.setPostContent(doc.get("content"));
//        return post;
//    }
//    
//    private boolean isFormatValid(String content) {
//        // 检查内容是否符合要求，例如是否以<p>开头，是否以</p>结尾等
//        // 这里根据具体格式要求来编写判断逻辑
//        return content.startsWith("<p>") && content.endsWith("</p>");
//    }
//}
