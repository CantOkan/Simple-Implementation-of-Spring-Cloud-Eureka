package com.university.studentservice.service;


import com.university.studentservice.dto.AddressResponse;
import com.university.studentservice.dto.StudentRequest;
import com.university.studentservice.dto.StudentResponse;
import com.university.studentservice.entity.Student;
import com.university.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    WebClient webClient;


    public StudentResponse createStudent(StudentRequest request){
        Student student=new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddressId(request.getAddressId());
        student=studentRepository.save(student);


        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setId(student.getId());
        studentResponse.setAddressResponse(getAddressById(student.getId()));

        return studentResponse;

    }


    public StudentResponse getById(Integer id){

        Student student=studentRepository.findById(id).get();
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setId(student.getId());
        studentResponse.setAddressResponse(getAddressById(id));
        return studentResponse;
    }


    private AddressResponse getAddressById(Integer id){
        Mono<AddressResponse> addressResponse=webClient.get().uri("/getById/"+id).retrieve()
                .bodyToMono(AddressResponse.class);

        return addressResponse.block();
    }
}
