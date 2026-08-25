package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRecordRepository extends JpaRepository<LoanRecord,Long> {
}
