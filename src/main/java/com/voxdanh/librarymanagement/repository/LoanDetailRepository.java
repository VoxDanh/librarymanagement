package com.voxdanh.librarymanagement.repository;

import com.voxdanh.librarymanagement.model.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanDetailRepository extends JpaRepository<LoanDetail,Long> {
}
