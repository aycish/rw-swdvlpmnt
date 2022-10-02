package documentsystem.system;

import documentsystem.document.Document;

import java.util.List;

public class DocumentManagementSystem {
    /**
     * 사용자가 문서 관리 시스템으로 관리하고자하는 파일을 등록
     *
     * @param path 대상의 파일 경로를 입력 받는다.
     */
    void importFile(String path) {
    }

    /**
     * 문서 관리 시스템에 저장된 모든 문서의 목록을 반환한다.
     * @return 등록된 모든 문서의 목록
     */
    List<Document> contents() {
        System.out.println("Not implement yet");
        return null;
    }
}
